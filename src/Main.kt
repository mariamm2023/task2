@file:Suppress("MISSING_DEPENDENCY_SUPERCLASS_IN_TYPE_ARGUMENT")

fun main() {
    // Requirement 1: Create and Populate Collections

    // Immutable list of student names
    val studentNames: List<String> = listOf("Ahmed", "Laila", "Nour", "Omar", "Sara")

    // Mutable map of student scores (name → score)
    val studentScores= mutableMapOf(
        "Ahmed" to 85,
        "Laila" to 72,
        "Nour" to 95,
        "Omar" to 58,
        "Sara" to 63
    )

    // Set of students who have already graduated
    val graduatedStudents = setOf("Omar")

    println("Student Names: $studentNames")
    println("Student Scores: $studentScores")
    println("Graduated Students: $graduatedStudents")


    //  Requirement 2: Looping and Searching

    println("\nLooping over students (excluding graduates):")
    for (name in studentNames) {
        if (name in graduatedStudents) continue
        println("Student: $name")
    }

    println("\n Find and print score for 'Nour':")
    println("Nour's Score: ${studentScores["Nour"]}")


    // Requirement 3: Transforming and Filtering with map and filter

    println("\nStudent Names in UPPERCASE:")
    val uppercasedNames = studentNames.map { it.uppercase() }
    println(uppercasedNames)

    println("\nStudents scoring above 80 (filter → map → print):")
    studentScores
        .filter { it.value > 80 }
        .map { "${it.key} passed with ${it.value}" }
        .forEach { println(it) }


    // Requirement 4: Reducing and Aggregation

    println("\nTotal score using reduce:")
    val totalScore = studentScores.values.reduce { acc, score -> acc + score }
    println("Total Score = $totalScore")

    println("\nFormatted score string using fold:")
    val formattedString = studentScores.entries.fold("") { acc, entry ->
        if (acc.isEmpty()) "${entry.key}: ${entry.value}"
        else "$acc | ${entry.key}: ${entry.value}"
    }
    println(formattedString)


    // Requirement 5: Mini Scenario – Student Report Generation

    println("\nStudent Grade Report:")
    generateReport(studentScores)
}

// unction to generate report
fun generateReport(scores: Map<String, Int>) {
    if (scores.isEmpty()) {
        println("No students available.")
        return
    }

    scores
        .filter { it.value >= 60 }
        .map { "${it.key}: Grade ${it.value}" }
        .forEach { println(it) }
}
