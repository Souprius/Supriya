package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Vehicle;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Repository
public class VehicleRepository {
    //Dependency
    //Without this, we can't connect to the database
    private final DataSource dataSource;

    //Autowired says, go and get me a copy of this
    @Autowired
    public VehicleRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    public List<Vehicle> getAllVehicles(){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)
            ){

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                int vin = rs.getInt("vin");
                int year = rs.getInt("year");
                String make = rs.getString("make");
                String model = rs.getString("model");
                String vehicleType = rs.getString("vehicleType");
                String color = rs.getString("color");
                int odometer = rs.getInt("odometer");
                double price = rs.getDouble("price");
                boolean sold = rs.getBoolean("Sold");

                Vehicle vehicle = new Vehicle(vin,year,make,model,vehicleType,color,odometer,price,sold);
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return vehicleList;
    }
    public List<Vehicle> getVehiclesByPrice(double min, double max){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE Price BETWEEN ? AND ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setDouble(1,min);
            ps.setDouble(2,max);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"), rs.getBoolean("Sold"));
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List <Vehicle> getVehiclesByMakeModel(String make, String model){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE Make = ? AND Model = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,make);
            ps.setString(2,model);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"),rs.getBoolean("Sold"));
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return vehicleList;
    }
    public List<Vehicle> getVehiclesByYear(int min, int max){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE Year = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,min);
            ps.setInt(2,max);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"),rs.getBoolean("Sold"));
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByColor(String color){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE Color = ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,color);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"),rs.getBoolean("Sold"));
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public List<Vehicle> getVehiclesByMileage(int min, int max){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE Odometer BETWEEN ? AND ?";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,min);
            ps.setInt(2,max);

            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"),rs.getBoolean("Sold"));
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }

        return vehicleList;
    }
    public List<Vehicle> getVehiclesByType(String vehicleType){

        List<Vehicle> vehicleList = new ArrayList<>();
        String query = "SELECT * FROM vehicles WHERE VehicleType = ?";

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1,vehicleType);

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                var vehicle = new Vehicle(rs.getInt("vin"), rs.getInt("year"),
                        rs.getString("make"), rs.getString("model"), rs.getString("color"),
                        rs.getString("type"), rs.getInt("odomoter"), rs.getDouble("price"),rs.getBoolean("Sold")
                );
                vehicleList.add(vehicle);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
        return vehicleList;
    }
    public void addVehicle(Vehicle vehicle){
        String query = "INSERT INTO vehicles(vin, year, make, model, vehicleType, color, odometer, price, Sold) VALUES(?,?,?,?,?,?,?,?,?)";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,vehicle.getVin());
            ps.setInt(2,vehicle.getYear());
            ps.setString(3,vehicle.getMake());
            ps.setString(4,vehicle.getModel());
            ps.setString(5,vehicle.getVehicleType());
            ps.setString(6,vehicle.getColor());
            ps.setInt(7,vehicle.getOdometer());
            ps.setDouble(8,vehicle.getPrice());
            ps.setBoolean(9, vehicle.isSold());

            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }
    public void removeVehicle(int id){
        String query = "DELETE FROM vehicles WHERE VehicleID = ?";

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,id);
            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch(Exception ex){
            ex.printStackTrace();
        }
    }

}