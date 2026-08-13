class CreateSalamanderScene {
    public static String createSalamanderScene(String name, int age, char favoritePlant) {
        StringBuilder scene = new StringBuilder();

        // Sun
        scene.append("    \\   /\n");
        scene.append("     \\ /\n");
        scene.append("   \\  O  /   Name: " + name + "\n");
        scene.append("    \\ | /    Age: " + age + " years old\n");

        // Pond with favorite plant
        scene.append("  ~~~~~~~~~\n");
        scene.append(" ~    ~    ~\n");
        scene.append("~  ~  ~  ~  ~\n");
        scene.append(" " + favoritePlant + favoritePlant + favoritePlant + " " + favoritePlant + favoritePlant + favoritePlant + " " + favoritePlant + favoritePlant + favoritePlant + "\n");

        // Salamander
        scene.append("    _____\n");
        scene.append("  .'     '.  " + name + " the Salamander\n");
        scene.append(" /  o   o  \\\n");
        scene.append("(    ^^^    )\n");
        scene.append(" \\  '___'  /\n");
        scene.append("  '._____.'");

        return scene.toString();
    }
}