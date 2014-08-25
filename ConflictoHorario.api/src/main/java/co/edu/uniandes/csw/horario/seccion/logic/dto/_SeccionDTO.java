/* ========================================================================
 * Copyright 2014 horario
 *
 * Licensed under the MIT, The MIT License (MIT)
 * Copyright (c) 2014 horario

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in
all copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
THE SOFTWARE.
 * ========================================================================


Source generated by CrudMaker version 1.0.0.201408112050

*/

package co.edu.uniandes.csw.horario.seccion.logic.dto;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement 
public abstract class _SeccionDTO {

	

	private Long id;
	

	private String name;
	

	private Integer cupoMaximo;
	

	private String salon;
	

	private Integer inscritos;
	

	private Long enespera_secccionId;
	

	private Long inscritos_seccionId;
	

	private Long profesor_seccionId;



	public Long getId() {
		return id;
	}
 
	public void setId(Long id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}
 
	public void setName(String name) {
		this.name = name;
	}


	public Integer getCupoMaximo() {
		return cupoMaximo;
	}
 
	public void setCupoMaximo(Integer cupomaximo) {
		this.cupoMaximo = cupomaximo;
	}


	public String getSalon() {
		return salon;
	}
 
	public void setSalon(String salon) {
		this.salon = salon;
	}


	public Integer getInscritos() {
		return inscritos;
	}
 
	public void setInscritos(Integer inscritos) {
		this.inscritos = inscritos;
	}


	public Long getEnespera_secccionId() {
		return enespera_secccionId;
	}
 
	public void setEnespera_secccionId(Long enespera_secccionid) {
		this.enespera_secccionId = enespera_secccionid;
	}


	public Long getInscritos_seccionId() {
		return inscritos_seccionId;
	}
 
	public void setInscritos_seccionId(Long inscritos_seccionid) {
		this.inscritos_seccionId = inscritos_seccionid;
	}


	public Long getProfesor_seccionId() {
		return profesor_seccionId;
	}
 
	public void setProfesor_seccionId(Long profesor_seccionid) {
		this.profesor_seccionId = profesor_seccionid;
	}
	
}