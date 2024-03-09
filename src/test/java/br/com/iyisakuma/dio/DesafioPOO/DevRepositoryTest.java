package br.com.iyisakuma.dio.DesafioPOO;

import br.com.iyisakuma.dio.DesafioPOO.domain.Dev;
import br.com.iyisakuma.dio.DesafioPOO.repository.DevRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class DevRepositoryTest {

    @Autowired
    private DevRepository repository;
    @Test
    public void insertDev(){
        var dev = new Dev();
        dev.setNome("yuji");
        dev = repository.save(dev);
        var devBD = repository.findById(dev.getId());
        Assertions.assertEquals(dev, devBD.get());
    }
}
