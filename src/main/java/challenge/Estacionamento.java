package challenge;

import java.util.ArrayList;
import java.util.List;

public class Estacionamento {

    List<Carro> estacionados = new ArrayList<Carro>();

    public void estacionar(Carro carro) {
      if(carro.getMotorista() == null || carro.getMotorista().getIdade() < 18 || carro.getMotorista().getPontos() > 20) throw new EstacionamentoException("Verificar.");
      if(estacionados.size() == 10){
          for(int x = 0; x < estacionados.size(); x++) {
              if (estacionados.get(x).getMotorista().getIdade() <= 55) {
                  estacionados.remove(x);
                  estacionados.add(carro);
                  break;
              }
              if(x == 9) throw new EstacionamentoException("Vagas indisponíveis");
          }
      }else {
          estacionados.add(carro);
      }
    }

    public int carrosEstacionados() {
        return estacionados.size();
    }

    public boolean carroEstacionado(Carro carro) {
        if(estacionados.contains(carro)){
            return true;
        }
        return false;
    }
}
