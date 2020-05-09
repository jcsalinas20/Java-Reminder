package memory;

import java.util.Timer;
import java.util.TimerTask;

public class Temporizador {

	public Temporizador(int segundos) {
		Timer timer = new Timer();
		TimerTask tarea = new TimerTask() {
			int tiempo = segundos;// numero de segundos.

			@Override
			public void run() {
				Main.lblTemporizador.setText("Tiempo restante: " + tiempo);//Recarga el JLabel cada segundo.
				tiempo--;//Restar uno al tiempo
				if (tiempo == -1) {//Cuando se iguala -1...
					timer.cancel();// Se cancela el "schedule" y se para,

					Main.lblTemporizador.setText("Intentos: 0");//Cambio de cuenta atras a numero de intentos,
					Main.ocultarImagenes();//Ocultar imagenes de botones,
					Main.mItemReiniciar.setEnabled(true);//Habilitar el boton reiniciar.

				}
			}
		};

		timer.schedule(tarea, 0, 1000);//(nameTask, delay, period(1000 = 1 segundo));
	}

}
