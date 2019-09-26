/**
 *
 */
package com.shumeng.application.video;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author wth
 */
@Repository
public interface AddrInstroDao extends JpaRepository<AddrInstro, Serializable>, JpaSpecificationExecutor<AddrInstro> {

}
