package com.example.colorpicker10

import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import java.io.File

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Activities that contain this fragment must implement the
 * [fragmentMain.OnFragmentInteractionListener] interface
 * to handle interaction events.
 * Use the [fragmentMain.newInstance] factory method to
 * create an instance of this fragment.
 */
data class Color(val colorName: String, val red: String, val green: String, val blue: String)


class fragmentMain : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null
    private var listener: OnFragmentInteractionListener? = null
    var colorData: List<Color> = emptyList()


    fun log(value: String) {
        Log.e("Test", value)
    }

    fun createDate(colors: List<String>) {
        colorData = emptyList()
        for (data in colors) {

        }


    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val path = context!!.filesDir
        val letDirectory = File(path, "LET")
        letDirectory.mkdirs()
        val file = File(letDirectory, "Colors.txt")
        if (file.exists()) {
            val inputAsString = file.readLines()
            log(inputAsString.size.toString())
            if (inputAsString.size > 0) {
                Log.e("Text File", inputAsString[inputAsString.size - 1])
            }
            Log.e("This is a test", "test")

        }


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }


    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     *
     *
     * See the Android Training lesson [Communicating with Other Fragments]
     * (http://developer.android.com/training/basics/fragments/communicating.html)
     * for more information.
     */
    interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        fun onFragmentInteraction(uri: Uri)
    }

    companion object {
        fun newInstance(): fragmentMain = fragmentMain()
    }
}
