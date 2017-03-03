/**
 * Teknei 2016
 */
package com.teknei.persistence.dao.disp;

import java.io.Serializable;
import java.util.Date;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.NoRepositoryBean;

/**
 * Interface for CRUD operations related to envi scheme classes
 * 
 * @author Jorge Amaro
 *
 * @param <T>
 *            - Envi scheme class
 * @param <ID>
 *            - ID primary key of the Envi scheme class
 */
@NoRepositoryBean
public interface CrudRepositoryDisp<T, ID extends Serializable> extends CrudRepository<T, ID> {

	public Long countByPkIdEquiAndFchCreaBetween(Integer idEqui, Date startDate, Date endDate);

}
