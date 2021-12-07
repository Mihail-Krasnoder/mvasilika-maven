package homework16;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Student {
    private int ID;
    private String Name;
    private int IdGroup;
    private int YearOfEntry;
}
