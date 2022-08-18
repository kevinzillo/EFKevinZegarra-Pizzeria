package EFKevinZegarraPizzeria.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import EFKevinZegarraPizzeria.Client.OpenFeignPizza;
import EFKevinZegarraPizzeria.DTO.Pizza;
import EFKevinZegarraPizzeria.Model.Pizzeria;
import EFKevinZegarraPizzeria.Model.PizzeriaDetalle;
import EFKevinZegarraPizzeria.Model.PizzeriaPizzaFK;
import EFKevinZegarraPizzeria.Repository.PizzeriaPizzaRepository;
import EFKevinZegarraPizzeria.Repository.PizzeriaRepository;

@Service
public class PizzeriaServiceImpl implements PizzeriaService {
	
	@Autowired
	private PizzeriaRepository repository;
	
	@Autowired
	private PizzeriaPizzaRepository repositoryDetalle;
	
	@Autowired
	private OpenFeignPizza feign;

	@Override
	public List<Pizzeria> listar() {
		// TODO Auto-generated method stub
		return repository.findAll();
	}

	@Override
	public Pizzeria ObtenerId(Integer id) {
		// TODO Auto-generated method stub
		return repository.findById(id).orElse(null);
	}

	@Override
	public void guardar(Pizzeria pizzeria) {
		// TODO Auto-generated method stub
		repository.save(pizzeria);

	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		repository.deleteById(id);

	}

	@Override
	public void actualizar(Pizzeria pizzeria) {
		// TODO Auto-generated method stub
		repository.saveAndFlush(pizzeria);

	}

	@Override
	public void asignarPizzaAPizzeria() {
		
		List<Pizza> listado= feign.listarPizzasSeleccionados();
		PizzeriaPizzaFK fk= null;
		PizzeriaDetalle detalle = null;
		
		for(Pizza pizza: listado) {
			
			fk=new PizzeriaPizzaFK();			
			fk.setIdPizza(pizza.getIdPizza());
			fk.setIdPizerria(1);
			
			detalle = new PizzeriaDetalle();
			detalle.setFk(fk);
			
			repositoryDetalle.save(detalle);
			
		}
		
	}

}
