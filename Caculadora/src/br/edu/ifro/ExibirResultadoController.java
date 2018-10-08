/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifro;
import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.stage.Stage;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import br.edu.ifro.historico.registro;

/**
 * FXML Controller class
 *
 * @author 04574926279
 */
public class ExibirResultadoController implements Initializable {

    @FXML
    private TableColumn<?, ?> tbid;
    @FXML
    private TableColumn<?, ?> tbPrimeiroValor;
    @FXML
    private TableColumn<?, ?> tbSegundoValor;
    @FXML
    private TableColumn<?, ?> tbOperador;
    @FXML
    private TableView<?> tbresultado;
    @FXML
    private TableColumn<?, ?> tbResultado;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        list();
   
    }    
  private void list(){
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("Calculadora");
        EntityManager em = emf.createEntityManager();
                
        // import javax.persistence.Query;
        Query query = em.createQuery("SELECT a FROM Histórico as a");
        // import java.util.List;
        // import br.edu.ifro.model.Aluno;
            List<registro> principal = query.getResultList();
        // import javafx.collections.ObservableList;
        // import javafx.collections.FXCollections;
        ObservableList registro = FXCollections.observableArrayList(principal); 
            tbresultado.setItems(registro);
    }
        
    }


