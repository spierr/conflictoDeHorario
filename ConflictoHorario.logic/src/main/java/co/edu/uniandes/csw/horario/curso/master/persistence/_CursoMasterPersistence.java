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

package co.edu.uniandes.csw.horario.curso.master.persistence;
import co.edu.uniandes.csw.horario.seccion.logic.dto.SeccionDTO;
import co.edu.uniandes.csw.horario.curso.master.persistence.entity.Cursoseccion_cursEntity;
import co.edu.uniandes.csw.horario.seccion.persistence.converter.SeccionConverter;
import co.edu.uniandes.csw.horario.curso.logic.dto.CursoDTO;
import co.edu.uniandes.csw.horario.curso.master.logic.dto.CursoMasterDTO;
import co.edu.uniandes.csw.horario.curso.master.persistence.api._ICursoMasterPersistence;
import co.edu.uniandes.csw.horario.curso.persistence.api.ICursoPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

public class _CursoMasterPersistence implements _ICursoMasterPersistence {

  	@PersistenceContext(unitName="ConflictoHorarioPU")
 
    protected EntityManager entityManager;
    
    @Inject
    protected ICursoPersistence cursoPersistence;  

    public CursoMasterDTO getCurso(Long cursoId) {
        CursoMasterDTO cursoMasterDTO = new CursoMasterDTO();
        CursoDTO curso = cursoPersistence.getCurso(cursoId);
        cursoMasterDTO.setCursoEntity(curso);
        cursoMasterDTO.setListseccion_curs(getCursoseccion_cursEntityList(cursoId));
        return cursoMasterDTO;
    }

    public Cursoseccion_cursEntity createCursoseccion_cursEntity(Cursoseccion_cursEntity entity) {
        entityManager.persist(entity);
        return entity;
    }

    public void deleteCursoseccion_cursEntity(Long cursoId, Long seccion_cursId) {
        Query q = entityManager.createNamedQuery("Cursoseccion_cursEntity.deleteCursoseccion_cursEntity");
        q.setParameter("cursoId", cursoId);
        q.setParameter("seccion_cursId", seccion_cursId);
        q.executeUpdate();
    }

    public List<SeccionDTO> getCursoseccion_cursEntityList(Long cursoId) {
        ArrayList<SeccionDTO> resp = new ArrayList<SeccionDTO>();
        Query q = entityManager.createNamedQuery("Cursoseccion_cursEntity.getByMasterId");
        q.setParameter("cursoId",cursoId);
        List<Cursoseccion_cursEntity> qResult =  q.getResultList();
        for (Cursoseccion_cursEntity entity : qResult) { 
            if(entity.getSeccion_cursIdEntity()==null){
                entityManager.refresh(entity);
            }
            resp.add(SeccionConverter.entity2PersistenceDTO(entity.getSeccion_cursIdEntity()));
        }
        return resp;
    }

}
