package data;

import java.io.IOException;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;

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
        // String型のArrayListの作成
        ArrayList<String> recipes = new ArrayList<>();
        try {
            // recipes.txtファイルを開く
            BufferedReader reader = new BufferedReader(new FileReader(filePath));
            String line;
            // ファイルから各行を読み込む
            while ((line = reader.readLine()) != null) {
                // 読み込んだ行をリストに追加する
                recipes.add(line);
            }
            // リーダーを閉じる
            reader.close();
        } catch (IOException e) {
            // IOExceptionが発生した場合、エラーメッセージをコンソールに表示
            System.out.println("Error reading file: " + e.getMessage());
        }
        // 読み込んだレシピデータのリストを返す
        return recipes;
    }

    // try {

    // } catch (IOException e) {
    // System.out.println("Error reading file:" + e.getMessage());
    // }
    // return null;
    // }

    /**
     * 設問2: 新規登録機能
     * 新しいレシピをrecipes.txtに追加します。<br>
     * レシピ名と材料はカンマ区切りで1行としてファイルに書き込まれます。
     *
     * @param recipeName  レシピ名
     * @param ingredients 材料名
     */
    //
    public void addRecipe(String recipeName, String ingredients) {
    try {
        FileWriter writer = new FileWriter(filePath, true); //trueにすることで前回の内容を保持する
        // レシピ名と材料をカンマで結合
        String newRecipe = recipeName + "," + ingredients;  //addnewRecipeから渡された レシピ名とカンマと材料
        // 新しいレシピをファイルに書き込む
        writer.write(newRecipe + "\n");                     //最後に改行しないと読み込みじに困る
        
        writer.close();
    } catch (IOException e) {
        System.out.println("Error reading file:" + e.getMessage());
    }
}
}
