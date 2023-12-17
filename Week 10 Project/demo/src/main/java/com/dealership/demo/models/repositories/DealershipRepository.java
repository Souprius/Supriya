package com.dealership.demo.models.repositories;

import com.dealership.demo.models.Dealership;
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
public class DealershipRepository {
    private final DataSource dataSource;

    @Autowired
    public DealershipRepository(DataSource dataSource){
        this.dataSource = dataSource;
    }

    //CRUD FUNCTIONS
    public List<Dealership> getAllDealerships(){
        List<Dealership> dealershipList = new ArrayList<>();
        String query = "SELECT * FROM dealerships";

        try(Connection conn = dataSource.getConnection();
            PreparedStatement ps = conn.prepareStatement(query)){

            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                var dealerships = new Dealership(rs.getInt("DealershipID"),rs.getString("name"),rs.getString("address"),rs.getString("phone"));
                dealershipList.add(dealerships);
            }

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return dealershipList;
    }

    public void createDealership(Dealership dealership){
        String query = "INSERT INTO dealerships(name,address,phone) VALUES(?,?,?)";

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, dealership.getName());
            ps.setString(2, dealership.getAddress());
            ps.setString(3,dealership.getPhone());

            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void updateDealership(Dealership dealership){
        String query = "UPDATE dealerships SET name = ? WHERE DealershipID = ?";

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setString(1, dealership.getName());
            ps.setInt(2,dealership.getDealershipID());

            ps.executeUpdate();

        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void removeDealership(int id){
        String query = "DELETE FROM dealerships WHERE DealershipID = ?";

        try(Connection conn = dataSource.getConnection();
        PreparedStatement ps = conn.prepareStatement(query)){

            ps.setInt(1,id);
            ps.executeUpdate();
        }catch(SQLException ex){
            ex.printStackTrace();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }
}
