package ru.da.soccerquiz

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import ru.da.soccerquiz.databinding.FragmentQuizBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [QuizFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class QuizFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    private  val quizItems:MutableList<QuizItem> = mutableListOf(
        QuizItem("Сколько игроков каждая команда имеет на поле в начале футбольного матча?",
            listOf("11", "8", "12")),
        QuizItem("Какой должна быть окружность футбольного мяча размера 5 (для взрослых)?",
            listOf("27\" to 28\"", "24\" to 25\"", "23\" to 24\"")),
        QuizItem("Что дают игроку за очень серьёзный персональный фол на сопернике?",
            listOf("Красная карточка", "Зеленая карта", "Желтая карточка")),
        QuizItem("В большинстве мест мира футбол известен как что?",
            listOf("Football", "Footgame", "Legball")),
        QuizItem("Офсайд. Если игрок находится в офсайде, какие действия предпринимает судья?",
            listOf("Назначает свободный удар противоположной команде.",
                "Назначает пенальти команде противника.",
                "Награждает игрока желтой карточкой")),
        QuizItem("Сколько существует законов футбольных ассоциаций?",
            listOf("17", "11", "23")),
        QuizItem("Какая часть тела, исключая вратаря, не может касаться мяча?",
            listOf("Рука", "Голова", "Плечо")),
        QuizItem("Как называется, когда игрок нападающей команды без мяча находится за последним защитником?",
            listOf("Офсайд", "Онсайд", "Полесайд")),
        QuizItem("Окружность мяча не должна быть больше ...?",
            listOf("70", "80", "90")),
        QuizItem("Сколько минут играется в обычной игре (без добавленного и дополнительного времени)?",
            listOf("90", "95", "100")),
        QuizItem("Какое утверждение описывает правильное вбрасывание?",
            listOf("Обе руки должны находиться на мяче за головой, обе ноги должны стоять на земле.",
                "Обе руки должны находиться на мяче за головой.",
                "Обе ноги должны стоять на земле")),
        QuizItem("Насколько велики официальные футбольные ворота?",
            listOf("Высота 2,44 м, ширина 7,32 м.",
                "Высота 2,55 м, ширина 7,62 м.",
                "Высота 2,33 м, ширина 8,15 м."))
    )

lateinit var currentQuizItem: QuizItem
lateinit var answer:MutableList<String>
private var quizIteIndex = 0
private val numberOfQuestions = 3

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.inflate<FragmentQuizBinding>(
            inflater, R.layout.fragment_quiz, container, false
        )

        getRandomQuizItem()
        binding.quizFragment = this



        return binding.root




    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment QuizFragment.
         */

        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            QuizFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    private fun getRandomQuizItem(){
        quizItems.shuffle()
        quizIteIndex = 0
        setQuizItem()
    }

    private fun setQuizItem() {
        currentQuizItem = quizItems[quizIteIndex]
        answer = currentQuizItem.answerList.toMutableList()
        answer.shuffle()
    }

}