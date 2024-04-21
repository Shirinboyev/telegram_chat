package backend.enums;
import static io.utils.Utils.*;

public enum Role {
    USER , ADMIN, BLOCK;

    public static Role choose() {
        int i = 1;
        for (Role value : values())
            System.out.println(i + ". " + value);

        int index = enterInt("Choose") - 1;

        if (index < 0 || index > values().length)
            return choose();

        return values()[index];
    }
}
