public class partido {
    private Integer numeroEquipo;
    private clases pareja1;
    private clases pareja2;

    private String resultado;
    private clases ganadores;
    private Integer ronda;

    public partido(Integer numeroEquipo, clases pareja1, clases pareja2, String resultado, clases ganadores, Integer ronda) {
        this.numeroEquipo = numeroEquipo;
        this.pareja1 = pareja1;
        this.pareja2 = pareja2;
        this.resultado = resultado;
        this.ganadores = ganadores;
        this.ronda = ronda;
    }

    //getters y setters
//    private static void generarRonda(){
//        int i = 0;
//        while(i < parejasTorneo.size()){
//            if (parejasTorneo.size() % 2 == 0){
//                partido partido = new partido(MaxIdPartido,
//                        parejasTorneo.get(i),
//                        parejasTorneo.get(i + 1),
//                        null,
//                        null,
//                        RondaActual);
//                MaxIdPartido++;
//            }else{
//                partido partido = new partido(MaxIdPartido,
//                        parejasTorneo.get(i),
//                        null,
//                        null,
//                        null,
//                        RondaActual);
//
//                partidosTorneo.add(partido);
//                MaxIdPartido++;
//                i = i + 2;
//            }
//        }
//        RondaActual ++;
//    }

}
