package orm;

import java.lang.reflect.Field;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//import com.sun.java.util.jar.pack.Package.Class.Field;

public abstract class BaseModel {

	private long id;
	
	public BaseModel save() throws NullPointerException, SQLException{
		if (this.id == 0) return this.create();
		else return this.update();
	}
	
	public long getId(){
		return this.id;
	}
	
	public abstract boolean delete();
	
	public String getForeignName(){
		return this.getClass().getSimpleName() + "_id";
	}
	
	public BaseModel update(){
		return this;
	}
	
	public BaseModel create() throws NullPointerException, SQLException{
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

	private String makeInsertStatement() {
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
				try {
					valuesString += ((BaseModel)f.get(this)).id + ",";
				} catch (IllegalArgumentException | IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				continue;
			}
			fieldsString += f.getName() + ",";
			String valueString="";
			try {
				valueString = f.get(this).toString();
			} catch (IllegalArgumentException | IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
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
}
