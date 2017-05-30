package com.sagitario.model.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.apache.log4j.Logger;

import com.sagitario.entitymanager.EntityManagerHelper;
import com.sagitario.exception.DatabaseExceptionCO;
import com.sagitario.model.dao.BaseDAO;

public abstract class BaseDAOImpl<BO, PO> implements BaseDAO<BO>{
	
	   protected EntityManager em;
	   protected Class<PO>     clase;
	   protected String        sTable;
	   protected String        sAliasTable = "model";
	   protected String        sOrderField;
	   protected Logger        logger      = Logger.getLogger(BaseDAOImpl.class);

	   public BaseDAOImpl(Class<PO> pcClase) {
		      clase = pcClase;
		      sTable = clase.getSimpleName();
		      em = this.getEntityManager();
		   }
		   
		   public BaseDAOImpl(Class<PO> pcClase, String psOrderField) {
		      this(pcClase);
		      sOrderField = psOrderField;
		   }

		   private EntityManager getEntityManager() {
		      return EntityManagerHelper.getEntityManager();
		   }

		   @Override
		   public BO save(BO pboElemento) throws DatabaseExceptionCO {
		      try {
		         PO poElemento;
		         em.getTransaction().begin();
		         poElemento = crearPO(pboElemento);
		         em.persist(poElemento);
		         poElemento = em.merge(poElemento);
		         em.getTransaction().commit();
		         pboElemento = crearBO(poElemento);
		      } catch (Exception ex) {
		         if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		         }
		         throw new DatabaseExceptionCO(ex.getMessage(), this.getClass());
		      }
		      return pboElemento;
		   }

		   @Override
		   public void delete(Integer id) throws DatabaseExceptionCO {
		      try {
		         PO poElemento;
		         em.getTransaction().begin();
		         poElemento = em.getReference(clase, id);
		         em.remove(poElemento);
		         em.getTransaction().commit();
		      } catch (Exception ex) {
		         if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		         }
		         throw new DatabaseExceptionCO(ex.getMessage(), this.getClass());
		      }
		   }

		   @Override
		   public BO update(BO pboElemento) throws DatabaseExceptionCO {
		      try {
		         PO poElemento;
		         em.getTransaction().begin();
		         poElemento = crearPO(pboElemento);
		         em.merge(poElemento);
		         em.getTransaction().commit();
		      } catch (Exception ex) {
		         if (em.getTransaction().isActive()) {
		            em.getTransaction().rollback();
		         }
		         ex.printStackTrace();
		         throw new DatabaseExceptionCO(ex.getMessage(), this.getClass());
		      }
		      return pboElemento;
		   }

		   @Override
		   public BO findById(Number id) {
		      em.clear();
		      PO poElemento = em.find(clase, id);
		      BO boElemento = null;
		      if (poElemento != null)
		         boElemento = crearBO(poElemento);
		      return boElemento;
		   }

		   @SuppressWarnings("unchecked")
		   @Override
		   public List<BO> findAll() {
		      List<BO> boElementos = new ArrayList<BO>();
		      BO boElemento;
		      StringBuffer sQuery = new StringBuffer("SELECT model FROM " + sTable + " " + sAliasTable + " ");
		      if (sOrderField != null) {
		         sQuery.append(" ORDER BY " + sAliasTable + "." + sOrderField);
		      }
		      Query query = em.createQuery(sQuery.toString());
		      List<PO> poElementos = query.getResultList();
		      for (PO poElemento : poElementos) {
		         boElemento = crearBO(poElemento);
		         boElementos.add(boElemento);
		      }
		      return boElementos;
		   }

		   protected abstract PO crearPO(BO pboElemento);

		   protected abstract BO crearBO(PO ppoElemento);
		}

