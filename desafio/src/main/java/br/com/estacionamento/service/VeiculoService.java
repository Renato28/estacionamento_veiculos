package br.com.estacionamento.service;

import br.com.estacionamento.dtos.VeiculoDTO;
import br.com.estacionamento.model.Veiculo;
import br.com.estacionamento.repository.VeiculoRepository;
import br.com.estacionamento.service.exception.EstabelecimentoNotFoundException;
import br.com.estacionamento.service.exception.VeiculoNotFoundException;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VeiculoService {

    @Autowired
    private VeiculoRepository veiculoRepository;

    @Autowired
    private ModelMapper mapper;

    public VeiculoDTO cadastrar(VeiculoDTO dto) {

        Veiculo veiculo = mapper.map(dto, Veiculo.class);
        veiculoRepository.save(veiculo);

        return mapper.map(veiculo, VeiculoDTO.class);
    }

    public VeiculoDTO atualizar(Long id, VeiculoDTO dto) {
        Veiculo veiculo = mapper.map(dto, Veiculo.class);
        veiculo.setId(id);
        veiculo = veiculoRepository.save(veiculo);

        return mapper.map(veiculo, VeiculoDTO.class);
    }

    public Page<VeiculoDTO> listar(Pageable paginacao) {

        if (paginacao == null || paginacao.getPageNumber() < 0 || paginacao.getPageSize() <= 0) {
            throw new IllegalArgumentException("Paginação inválida!");
        }

        return veiculoRepository.
                findAll(paginacao).map(v -> mapper.map(v, VeiculoDTO.class));

    }

    public VeiculoDTO listarPorId(Long id) {
        Veiculo veiculo = veiculoRepository.
                findById(id).orElseThrow(() -> new VeiculoNotFoundException("Veiculo não encontrado"));

        return mapper.map(veiculo, VeiculoDTO.class);
    }

    public void excluir(Long id) {
        veiculoRepository.deleteById(id);
    }

    public VeiculoDTO findbyPlaca(String placa) {
        List<Veiculo> veiculos = veiculoRepository.findByPlaca(placa);

        for (Veiculo veiculo : veiculos) {
            VeiculoDTO dto = mapper.map(veiculo, VeiculoDTO.class);

            if (dto.getPlaca().equals(placa)) {
                return dto;
            }
        }

        throw new VeiculoNotFoundException("Essa placa nao existe");
    }

}
