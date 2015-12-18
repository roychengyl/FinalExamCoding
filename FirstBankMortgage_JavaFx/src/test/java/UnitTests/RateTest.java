package UnitTests;


import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;

import java.util.UUID;

import base.RateDAL;
import ch.makery.address.MainApp;
import ch.makery.address.model.Rate;
import domain.RateDomainModel;

import static ch.makery.address.model.Rate.*;
import static org.junit.Assert.assertEquals;

import org.apache.poi.ss.formula.functions.FinanceLib;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import domain.RateDomainModel;
import ch.makery.address.model.Rate;


public class RateTest {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		
		Rate rate = new Rate();
		
		assertEquals(FinanceLib.pmt(0.04/12, 360, -300000, 0, false), rate.getPayment(700, 30 * 12, -300000), 0.01);
		assertEquals(FinanceLib.pmt(0.035/12, 180, -200000, 0, false), rate.getPayment(800, 15 * 12, -200000), 0.01);
		
	}

}
