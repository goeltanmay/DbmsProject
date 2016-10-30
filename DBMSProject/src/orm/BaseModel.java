package orm;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Objects;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

//import com.sun.java.util.jar.pack.Package.Class.Field;

public class BaseModel {

	public long id;
	
	public BaseModel save() throws NullPointerException, SQLException, IllegalArgumentException, IllegalAccessException{
		if (this.id == 0) return this.create();
		else return this.update();
	}
	
	public long getId(){
		return this.id;
	}
	
	public boolean delete() throws NullPointerException, SQLException
	{
		if(this.id != 0)
		{
			String deleteQuery=String.format("delete from %s where id=%d",this.getClass().getSimpleName(),this.id);
			ConnectionManager.getDbConnection().createStatement().executeQuery(deleteQuery);
			return true;
			
		}
		
		return false;
	}
	
	public BaseModel update() throws SQLException, IllegalArgumentException, IllegalAccessException
	{
		
		String updateStatement=makeUpdateStatement();
		
		// execute the statement
		PreparedStatement psmt = ConnectionManager.getDbConnection().prepareStatement(updateStatement);
		psmt.executeUpdate();
		
		return this;
	}
	
	private String makeUpdateStatement() throws IllegalArgumentException, IllegalAccessException 
	{
		// TODO Auto-generated method stub
		//Fetching the type of object to be updated
        String nameOfClass = this.getClass().getSimpleName();
        
        System.out.println(nameOfClass);
		// make the insert statement stub.
		String updateStatement = String.format("Update %s set ", nameOfClass);
		
		// figure out all the fields and their type
		Field[] fields = this.getClass().getFields();
	
		String valueString="";
		
		for (Field f : fields)
		{
			valueString="";
			
			if(BaseModel.class.isAssignableFrom(f.getType()))
			{
				// detecting foreign keys
				updateStatement += f.getName() + "=";
				if((BaseModel)f.get(this) != null)
					updateStatement += ((BaseModel)f.get(this)).id + ",";
				else 
					updateStatement += "null,";
				continue;
			}
			
			updateStatement += f.getName() + "=";
			
			valueString = f.get(this).toString();
			
			if(f.getType() == String.class){
				valueString = "'" + valueString + "'";
			}
			valueString +=",";
			
			updateStatement += valueString;
			System.out.println(updateStatement);
		}
		
//		System.out.println("the final update statement is:"+updateStatement);
		
		if (updateStatement.endsWith(",")) {
		    updateStatement = updateStatement.substring(0, updateStatement.length() - 1);
		}
		
		updateStatement+=" where id="+this.id; 
        
//		System.out.println("the final update statement is:"+updateStatement);
		//returns the final update query
		return updateStatement;
	}

	public BaseModel create() throws NullPointerException, SQLException, IllegalArgumentException, IllegalAccessException{
		// get name of the class whose object has been saved
		String insertStatement = makeInsertStatement();
		// execute the statement
		PreparedStatement psmt = ConnectionManager.getDbConnection().prepareStatement(insertStatement, new String[]{"id"});
		psmt.executeUpdate();
		// parse the output
		// return the formed object.
		ResultSet rs = psmt.getGeneratedKeys();
		rs.next();
		this.id = rs.getLong(1);
		return this;
	}

	private String makeInsertStatement() throws IllegalArgumentException, IllegalAccessException {
		String nameOfClass = this.getClass().getSimpleName();
		
		// make the insert statement stub.
		String insertStatement = String.format("Insert into %s ", nameOfClass);
		
		// figure out all the fields and their type
		Field[] fields = this.getClass().getFields();
		String fieldsString="(";
		String valuesString="(";
		
		// iterate over the fields and add them to a values string.
		// add the values string at the end of the method to the insert statement.		
		for (Field f : fields){
			if(BaseModel.class.isAssignableFrom(f.getType())){
				// detecting foreign keys
				fieldsString += f.getName() + ",";
				if((BaseModel)f.get(this) != null)
					valuesString += ((BaseModel)f.get(this)).id + ",";
				else
					valuesString +="null, ";
				continue;
			}
			fieldsString += f.getName() + ",";
			String valueString="";
			
			valueString = f.get(this).toString();
			
			if(f.getType() == String.class){
				valueString = "'" + valueString + "'";
			}
			valueString +=",";
			
			valuesString += valueString;
		}
		
		// removing trailing Ss.
		if (fieldsString.endsWith(",")) {
		    fieldsString = fieldsString.substring(0, fieldsString.length() - 1);
		}
		
		if (valuesString.endsWith(",")) {
		    valuesString = valuesString.substring(0, valuesString.length() - 1);
		}
		
		fieldsString +=")";
		valuesString +=")";
		
		insertStatement += fieldsString + " values "+ valuesString;
		return insertStatement;
	}
	
	public static ResultSet selectRaw(String statement) throws SQLException {
		return ConnectionManager.getDbConnection().createStatement().executeQuery(statement);
	}
	
	public static ArrayList<Object> select(Class clss, String where) {
		String queryString = String.format("select * from %s",clss.getSimpleName());
		if(!where.equalsIgnoreCase("")) queryString += " where "+ where ;
		ResultSet resultSet = null;
		ArrayList<JsonObject> jsonArrayList = new ArrayList<JsonObject>();
		ArrayList<Object> objectArrayList= new ArrayList<Object>();
		
		try {
			resultSet = ConnectionManager.getDbConnection().createStatement().executeQuery(queryString);
		} catch (NullPointerException | SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		try {
			 jsonArrayList = parseResult(clss, resultSet);
			 
		} catch (SQLException | InstantiationException | IllegalAccessException e ) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
		
		
		Gson gson = new Gson();

		
		for(JsonObject obj:jsonArrayList)
		{
			objectArrayList.add(gson.fromJson(obj,clss));
		}
		
		return objectArrayList;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseModel other = (BaseModel) obj;
		if (id != other.id)
			return false;
		return true;
	}

	private static ArrayList<JsonObject> parseResult(Class clss, ResultSet resultSet) throws SQLException, InstantiationException, IllegalAccessException {
		ArrayList<JsonObject> arrayList = new ArrayList<JsonObject>();
		if(resultSet != null)
			while(resultSet.next()){
				JsonObject jsonObject = new JsonObject();
				Gson gson = new Gson();
				for (Field f : clss.getFields())
				{
					if(f.getType() == long.class) jsonObject.addProperty(f.getName(), resultSet.getLong(f.getName()));
					else if(f.getType() == int.class) jsonObject.addProperty(f.getName(), resultSet.getInt(f.getName()));
					else if(f.getType() == String.class) jsonObject.addProperty(f.getName(), resultSet.getString(f.getName()));
					else if(f.getType() == double.class) jsonObject.addProperty(f.getName(), resultSet.getDouble(f.getName()));
					else if(f.getType() == float.class) jsonObject.addProperty(f.getName(), resultSet.getFloat(f.getName()));
					else if(BaseModel.class.isAssignableFrom(f.getType())){
						long id = resultSet.getLong(f.getName());
						String where = "id = " + id;
						ArrayList<Object> list = BaseModel.select(f.getType(), where);
						if(list.size()>0) jsonObject.add(f.getName(), gson.toJsonTree(list.get(0)));
					}
					
				}
				arrayList.add(jsonObject);
			}
		return arrayList;
	}
	
}
