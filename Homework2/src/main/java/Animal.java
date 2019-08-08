import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@Data
public class Animal {
    private String name;
    private String sound;
    private Boolean flag;

    void speak(int times){

        if (flag){
            System.out.print(name+ ": ");
            for (int i=0; i<times; i++){
                if (i == times -1) {
                    System.out.println(sound.toUpperCase());
                } else {
                    System.out.print(sound.toUpperCase()+" ");
                }

            }
        } else {
            System.out.print(name+ ": ");
            for (int i=0; i<times; i++){
                if (i == times -1) {
                    System.out.println(sound.toLowerCase());
                } else {
                    System.out.print(sound.toLowerCase()+" ");
                }
            }
        }
    }

    public static void main(String[] args) {
        List<Animal> zoo = new ArrayList<>();
        zoo.add(new Animal("Big dog","woof",true));
        zoo.add(new Animal("cow","moo",true));
        zoo.add(new Animal("Small dog","woof",false));
        zoo.add(new Animal("frog","croak",false));


        System.out.println("Loud animals");
        for (Animal one: zoo) {
            if (one.flag) {
                int mult = 1+(int) (Math.random()*5);
                one.speak(mult);
            }
        }
        System.out.println("Quiet animals");
        for (Animal one: zoo) {
            if (!one.flag) {
                int mult = 1+(int) (Math.random()*5);
                one.speak(mult);
            }
        }
    }

}