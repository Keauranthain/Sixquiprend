package Data;
import lombok.Getter;
import lombok.Setter;
@Getter @Setter
public class Card {
    int number;
    int bullhead;

    public Card(int number){
        this.number = number;
        if (number == 55){
            this.bullhead = 7;
        } else if (number % 11 == 0){
            this.bullhead = 5;
        } else if (number % 10 == 0) {
            this.bullhead = 3;
        }
        else if (number % 5 == 0) {
            this.bullhead = 2;
        }else {
            this.bullhead = 1;
        }
    }

}