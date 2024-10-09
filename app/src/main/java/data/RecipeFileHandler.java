package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;

public class RecipeFileHandler {
    private String filePath;

    public RecipeFileHandler() {
        filePath = "app/src/main/resources/recipes.txt";
    }

    public RecipeFileHandler(String filePath) {
        this.filePath = filePath;
    }

    /**
     * 設問1: 一覧表示機能
     * recipes.txtからレシピデータを読み込み、それをリスト形式で返します。 <br> 
     * IOExceptionが発生したときは<i>Error reading file: 例外のメッセージ</i>とコンソールに表示します。
     *
     * @return レシピデータ
     */
    public ArrayList<String> readRecipes() {
        //String型のArrayListの作成
        ArrayList<String> recipeList = new ArrayList();
        String fileName = "app/src/main/resources/recipes.txt";
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))){ 
            String line;
                while((line = reader.readLine()) != null) {
                    recipeList.add(line);
                }
        }catch (IOException e) {
            System.out.println("Error reading file:" + e.getMessage());
            }
        return recipeList;
    }
        

        // try {

        // } catch (IOException e) {
        //     System.out.println("Error reading file:" + e.getMessage());
        // }
        //return null;
        //}

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName レシピ名
     * @param ingredients 材料名
     */
     // 
    public void addRecipe(String recipeName, String ingredients) {
        // try {

        // } catch (IOException e) {

        // }
    }
}
