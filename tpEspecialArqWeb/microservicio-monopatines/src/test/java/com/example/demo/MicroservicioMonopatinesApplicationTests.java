package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;

import com.example.demo.controller.MonopatinController;
import com.example.demo.model.Monopatin;

@SpringBootTest
class MicroservicioMonopatinesApplicationTests {

	private MonopatinController monopatinController;

	@Autowired
	public MicroservicioMonopatinesApplicationTests(MonopatinController monopatinController) {
		this.monopatinController=monopatinController;
	}

	/*@Test
	void testGetMonopatinById() {
		Long id = (long) 2;
		ResponseEntity<?> monopatin = this.monopatinController.traerPorId(id);
		if(monopatin != null ){
			System.out.println("Encontre el monopatin : " + monopatin.getBody());
			Assert.isTrue(monopatin.getStatusCode().equals(HttpStatus.BAD_GATEWAY));//Si da error significa que anda bien, Se puede cambiar el HttpStatus.BAD_GATEWAY por HttpStatus.OK y no deberia dar error
		}
        
	}

	/*@Test
	void testCreateMonopatin() {
        Monopatin nuevo = new Monopatin();
        Long id = (long) 1;
		nuevo.setId(id);
		nuevo.setEstado("disponible");
		nuevo.setGps((long) 2141);
        nuevo.setLocacion("Tandil");
        if(this.monopatinController.traerPorId(id).getStatusCode().equals(HttpStatus.OK)) {
        	System.out.println("No se pudo agregar el monopatin con id : " + id);
        	Assert.isTrue(false);// Si da error significa que funciona correctamente, ya que no se puede crear un nuevo monopatin con una id ya existente
        }else {
        	this.monopatinController.crearMonopatin(nuevo);   
        	System.out.println("Se pudo agregar el monopatin con id : " + id);
        }


    }*/

}
