
package edu.temple.inclassactivity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Get the images
        val typedArray = resources.obtainTypedArray(R.array.image_ids)
        val imageArray = IntArray(typedArray.length()) {
            typedArray.getResourceId(it, 0)
        }
        typedArray.recycle()

        // Display the images
        if (savedInstanceState == null) {
            val fragment = ImageDisplayFragment.newInstance(imageArray)

            supportFragmentManager.beginTransaction()
                .add(R.id.fragmentContainerView, fragment)
                .commit()
        }
    }
}
