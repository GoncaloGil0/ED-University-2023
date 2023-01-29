/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package pt.ed2023.main;
import pt.ed2023.exceptions.EmptyCollectionException;
import pt.ed2023.exceptions.NonComparableElementException;
import pt.ed2023.exceptions.NullException;
import pt.ed2023.exceptions.UnknownPathException;
import java.io.IOException;
import org.json.simple.parser.ParseException;

/**
 * 
 * @author 8200335
 */
public class ED_2023 {

    public static void main(String[] args) throws IOException, ParseException, NonComparableElementException, EmptyCollectionException, NullException, UnknownPathException, InterruptedException {
        pt.ed2023.utils.apiHandler.mainAPI(new Jogo());
    }
    
}
