/**
 * Code by Kujaku
 * En Kotlin ❤
 * Created at 23/10/2019
 */
import java.util.Scanner

class Trajet {
    fun villeDepart(){
        val villeDepart = arrayOf("Bordeaux", "Paris", "Toulouse", "Angers")
        println("Veuillez rentrer une ville de départ: ")
        val input = Scanner(System.`in`)
        val T = input.nextLine()

        if (T in villeDepart){
            println("Ta ville départ est : $T")
            villeArrive(T)
        }else{
            println("La ville que tu a rentré n'est pas dans la liste des villes de départ")
            villeDepart()
        }
    }
    fun villeArrive(T: String){
        val villeArrive = arrayOf("Bordeaux", "Paris", "Toulouse", "Angers")
        val input = Scanner(System.`in`)
        println("Veuillez rentrer une ville d'arrivé: ")
        val Y = input.nextLine()
        if (Y != T){
            if (Y in villeArrive){
                println("Ta ville d'arriver est $Y")
                distance(T, Y)
            }else{
                println("La ville que tu a rentré n'est pas dans la liste des villes d'arrivé")
                villeArrive(T)
            }
        }else{
            println("Tu ne peux pas sélectionner la même ville que celle de départ !")
            villeArrive(T)
        }
    }
    fun distance(T: String, Y: String){
        val bdx_paris = 582
        val bdx_angers = 396
        val bdx_toulouse = 245
        val paris_angers = 293
        val paris_toulouse = 676
        val angers_toulouse = 635
        var dist: Int = 0
        when (T) {
            "Bordeaux" -> when (Y) {
                "Paris" -> dist = bdx_paris
                "Angers" -> dist = bdx_angers
                "Toulouse" -> dist = bdx_toulouse
            }
            "Paris" -> when (Y) {
                "Bordeaux" -> dist = bdx_paris
                "Angers" -> dist = paris_angers
                "Toulouse" -> dist = paris_toulouse
            }
            "Angers" -> when (Y) {
                "Bordeaux" -> dist = bdx_angers
                "Paris" -> dist = paris_angers
                "Toulouse" -> dist = angers_toulouse
            }
            "Toulouse" -> when (Y) {
                "Bordeaux" -> dist = bdx_toulouse
                "Paris" -> dist = paris_toulouse
                "Angers" -> dist = angers_toulouse
            }
        }

        fun temps(dist: Int): String{

            var duree  = 0.0F
            val nbrPause = dist / 168
            duree = nbrPause * 2.0F + nbrPause * 0.25F
            var distanceRest: Float = dist.toFloat() - (nbrPause * 168)
                if (distanceRest >= 15){
                    distanceRest -= 15
                    duree += 0.3F
                    duree += distanceRest / 90
                }else{
                    duree += 0.15F
                }
            return Conversion().decimalToHeure(duree)
        }

        val resultTableau = arrayOf("Ville de départ : $T", "Ville d'arrivé : $Y", "Distance : $dist KM", "Temps : ${temps(dist)}")
        println(resultTableau.contentToString())
        //println("${resultTableau[0]} $T")
        //println("${resultTableau[1]} $Y")
        //println("${resultTableau[2]} $dist KM")
        //println("${resultTableau[3]} ${temps(dist)}")
    }
}