package br.com.estacionamento.config;

import br.com.estacionamento.dtos.request.RegistroEstacionamentoRequestDTO;
import br.com.estacionamento.model.RegistroEstacionamento;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ConfiguracaoModelMapper {

    @Bean
    public ModelMapper modelMapper() {
        ModelMapper modelMapper = new ModelMapper();

        modelMapper.addMappings(new PropertyMap<RegistroEstacionamentoRequestDTO, RegistroEstacionamento>() {
            protected void configure() {
                skip().setId(null);
            }
        });

        return modelMapper;
    }

}
