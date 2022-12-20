import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.DefaultListModel;
import javax.swing.JList;

public class AddBD {
	public void populateJList(JList<String> list, String query, Connection connection) throws SQLException
	{
	    DefaultListModel<String> model = new DefaultListModel<String>(); //create a new list model

	    Statement statement = connection.createStatement();
	    ResultSet resultSet = statement.executeQuery(query); //run your query

	    while (resultSet.next()) //go through each row that your query returns
	    {
	        String itemCode = resultSet.getString("nume"); //get the element in column "nume"
	        model.addElement(itemCode); //add each item to the model
	    }
	    list.setModel(model);

	    resultSet.close();
	    statement.close();

	}
}
