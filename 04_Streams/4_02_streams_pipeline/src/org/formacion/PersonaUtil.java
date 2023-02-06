package org.formacion;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class PersonaUtil {


    /** todos los metodos deben construir streams a partir de esta lista */
    private List<Persona> bbdd = new ArrayList<>();

    public PersonaUtil() {
        bbdd.add(new Persona ("Antonia","Garcia", Optional.of("Sastre")));
        bbdd.add(new Persona ("John","smith", Optional.empty()));
        bbdd.add(new Persona ("Pedro","Llull", Optional.of("Mir")));
    }


    /**
     * Devuelve stream con las personas que no tiene segundo apellido
     */
    public Stream<Persona> listaSinApellido2() {
        return bbdd.stream().filter(p -> !p.getApellido2().isPresent());
    }

    /**
     * Devuelve stream con los nombres de todas las personas
     */
    public Stream<String> listaNombres() {
        return bbdd.stream().map(Persona::getNombre);
    }

    /**
     * Devuelve stream con primer apellido ordenado sin tener en cuenta mayusculas / minusculas
     * pista: metodo de String compareToIgnoreCase
     */
    public Stream<String> listaApellido1Ordenada() {
        return bbdd.stream()
        		.map(Persona::getApellido1)
        		.sorted((ap1, ap2) -> ap1.compareToIgnoreCase(ap2));
    }

}
