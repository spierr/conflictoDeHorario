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

package co.edu.uniandes.csw.horario.curso.persistence;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.edu.uniandes.csw.horario.curso.logic.dto.CursoDTO;
import co.edu.uniandes.csw.horario.curso.persistence.api._ICursoPersistence;
import co.edu.uniandes.csw.horario.curso.persistence.converter.CursoConverter;
import co.edu.uniandes.csw.horario.curso.persistence.entity.CursoEntity;

public abstract class _CursoPersistence implements _ICursoPersistence {

  	@PersistenceContext(unitName="ConflictoHorarioPU")
 
	protected EntityManager entityManager;
	
	public CursoDTO createCurso(CursoDTO curso) {
		CursoEntity entity=CursoConverter.persistenceDTO2Entity(curso);
		entityManager.persist(entity);
		return CursoConverter.entity2PersistenceDTO(entity);
	}

	@SuppressWarnings("unchecked")
	public List<CursoDTO> getCursos() {
		Query q = entityManager.createQuery("select u from CursoEntity u");
		return CursoConverter.entity2PersistenceDTOList(q.getResultList());
	}

	public CursoDTO getCurso(Long id) {
		return CursoConverter.entity2PersistenceDTO(entityManager.find(CursoEntity.class, id));
	}

	public void deleteCurso(Long id) {
		CursoEntity entity=entityManager.find(CursoEntity.class, id);
		entityManager.remove(entity);
	}

	public void updateCurso(CursoDTO detail) {
		CursoEntity entity=entityManager.merge(CursoConverter.persistenceDTO2Entity(detail));
		CursoConverter.entity2PersistenceDTO(entity);
	}

}