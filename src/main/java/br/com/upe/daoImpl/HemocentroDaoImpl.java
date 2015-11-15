package br.com.upe.daoImpl;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import br.com.upe.dao.AbstractDao;
import br.com.upe.dao.HemocentroDao;
import br.com.upe.model.Hemocentro;

@Repository("hemocentroDao")
public class HemocentroDaoImpl extends AbstractDao<Integer, Hemocentro>
		implements HemocentroDao {

	public Hemocentro findById(int id) {
		return getByKey(id);
	}

	public void saveHemocentro(Hemocentro Hemocentro) {
		persist(Hemocentro);
	}

	public void deleteHemocentroById(int id) {
		Query query = getSession().createSQLQuery("delete from Hemocentro where id = :id");
		query.setInteger("id", id);
		query.executeUpdate();
	}

	@SuppressWarnings("unchecked")
	public List<Hemocentro> findAllHemocentros() {
		Criteria criteria = createEntityCriteria();
		return (List<Hemocentro>) criteria.list();
	}

	public Hemocentro findHemocentroById(int id) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("id", id));
		return (Hemocentro) criteria.uniqueResult();
	}
	
	public Hemocentro findHemocentroByNome(String nome) {
		Criteria criteria = createEntityCriteria();
		criteria.add(Restrictions.eq("nome", nome));
		return (Hemocentro) criteria.uniqueResult();
	}

}
