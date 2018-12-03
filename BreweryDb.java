package edu.ncsu.csc.csc216.heckman_brewery.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import edu.ncsu.csc.csc216.heckman_brewery.beer.Ale;
import edu.ncsu.csc.csc216.heckman_brewery.beer.Beer;

public class BreweryDb {
	
	private Connection conn;
	private static final String DRIVER = "org.apache.derby.jdbc.EmbeddedDriver";
	private static final String BEER_TABLE = "CREATE TABLE Beer (name varchar(20), brew_date long, starting_gravity int, ending_gravity int)";
	
	public void connect(String url) {
		try {
			Class.forName(DRIVER);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		try {
			conn = DriverManager.getConnection(url);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void disconnect() {
		try {
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public void createTables() {
		PreparedStatement ps = null;
		try {
			ps = conn.prepareStatement(BEER_TABLE);
			ps.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Beer> getBeers() {
		ArrayList<Beer> beers = new ArrayList<Beer>();
		try {
			String query = "SELECT name from Beer";
			ResultSet rs = conn.prepareStatement(query).executeQuery();
			while (rs.next()) {
				beers.add(new Ale(rs.getString("name")));
			}
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return beers;
	}

}
