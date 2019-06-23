package application.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import application.model.Prato;
import application.repository.PratoRepository;
import application.utils.ProjectFileUtils;

@Service
public class PratoService {
	@Autowired
	private PratoRepository pratoRepository;
	
	public void salvarPrato(Prato prato, MultipartFile imagem) {
		
		String path = "images/"+ prato.getNome() + ".png"; //???
		ProjectFileUtils.salvarImagem(path, imagem);
		pratoRepository.save(prato);
	}
	public List<Prato> listarPratos(){
		return pratoRepository.findAll();
	}
	public void deletarPratoPorId(Long id) {
		pratoRepository.deleteById(id);
	}
	public Prato buscarPratoPorId(Long id) {
		return pratoRepository.getOne(id);
	}
}
