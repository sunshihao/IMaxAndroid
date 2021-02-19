
package com.example.bttomnavi.util

import androidx.databinding.BindingMethod
import androidx.databinding.BindingMethods
import android.widget.ImageView


/**
 * `app:srcCompat` is an attribute used by the support library to integrate vector drawables. This
 * BindingMethod binds the attribute to the setImageDrawable method in the ImageView class.
 *
 * Binding methods have to be applied to any class in your project. Even an empty one.
 *
 * This is equivalent to:
 * ```
 *
 *   @BindingAdapter("app:srcCompat")
 *   @JvmStatic fun srcCompat(view: ImageView, @DrawableRes drawableId: Int) {
 *       view.setImageResource(drawable)
 *   }
 * ```
 */
@BindingMethods(
        BindingMethod(type = ImageView::class,
                attribute = "srcCompat",
                method = "setImageResource"))
class MyBindingMethods
