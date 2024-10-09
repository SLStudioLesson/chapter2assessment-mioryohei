package ui;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import data.RecipeFileHandler;

public class RecipeUI {
    private BufferedReader reader;
    private RecipeFileHandler fileHandler;

    public RecipeUI() {
        reader = new BufferedReader(new InputStreamReader(System.in));
        fileHandler = new RecipeFileHandler();
    }

    public RecipeUI(BufferedReader reader, RecipeFileHandler fileHandler) {
        this.reader = reader;
        this.fileHandler = fileHandler;
    }

    public void displayMenu() {
        while (true) {
            try {
                System.out.println();
                System.out.println("Main Menu:");
                System.out.println("1: Display Recipes");
                System.out.println("2: Add New Recipe");
                System.out.println("3: Search Recipe");
                System.out.println("4: Exit Application");
                System.out.print("Please choose an option: ");

                String choice = reader.readLine();

                switch (choice) {
                    case "1":
                        // 設問1: 一覧表示機能
                        displayRecipes();
                        break;
                    case "2":
                        // 設問2: 新規登録機能
                        addNewRecipe();
                        break;
                    case "3":
                        // 設問3: 検索機能
                        break;
                    case "4":
                        System.out.println("Exit the application.");
                        return;
                    default:
                        System.out.println("Invalid choice. Please select again.");
                        break;
                }
            } catch (IOException e) {
                System.out.println("Error reading input from user: " + e.getMessage());
            }
        }
    }

    /**
     * 設問1: 一覧表示機能
     * RecipeFileHandlerから読み込んだレシピデータを整形してコンソールに表示します。
     */
    private void displayRecipes() {
        ArrayList<String> recipes = fileHandler.readRecipes();
    
        if (recipes.isEmpty()) {
            System.out.println("No recipes available.");
        } else {
            System.out.println("Recipes:");
            System.out.println("-----------------------------------");
            for (String recipe : recipes) {
                String[] parts = recipe.split(","); // カンマで分割 partsに 改行で0から
                if (parts.length >= 2) {                  //長さは１から　１は含めいないので２から
                    String recipeName = parts[0].trim(); // １は含めいないけど番地は0
    
                    String reset = ""; // 材料の文字列を初期化　
                    for (int i = 1; i < parts.length; i++) {    //partsの長さは分割した数の１を抜くので２よりおおきいとき
                        if (i > 1) {
                            reset += ", "; // 最初の材料以外にはカンマとスペースを追加
                        }
                        reset += parts[i].trim(); // 材料を追加
                    }
    
                    // レシピ名と材料を表示
                    System.out.println("Recipe Name: " + recipeName);
                    System.out.println("Main Ingredients: " + reset);
                }
                System.out.println("-----------------------------------");
            }
        }
    }
    

    /**
     * 設問2: 新規登録機能
     * ユーザーからレシピ名と主な材料を入力させ、RecipeFileHandlerを使用してrecipes.txtに新しいレシピを追加します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void addNewRecipe() throws IOException {

        System.out.print("Enter recipe name: ");
        String recipeName = reader.readLine();  //レシピ名
    
        System.out.print("Enter main ingredients (comma separated): ");
        String ingredients = reader.readLine(); //材料
    
        fileHandler.addRecipe(recipeName, ingredients);  //入力した内容をaddRecipe()に返す
    
        System.out.println("Recipe added successfully.");
    }

    /**
     * 設問3: 検索機能
     * ユーザーから検索クエリを入力させ、そのクエリに基づいてレシピを検索し、一致するレシピをコンソールに表示します。
     *
     * @throws java.io.IOException 入出力が受け付けられない
     */
    private void searchRecipe() throws IOException {

    }

}
