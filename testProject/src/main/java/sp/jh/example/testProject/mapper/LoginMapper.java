package sp.jh.example.testProject.mapper;


import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import sp.jh.example.testProject.domain.LoginDTO;

@Repository
@Component("sp.jh.example.testProject.mapper.LoginMapper")
public interface LoginMapper  {
	LoginDTO getUsers(LoginDTO dto) throws Exception;

	public Integer registUsers(LoginDTO dto) throws Exception;

}
