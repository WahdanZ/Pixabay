package com.wahdanz.pixabay.extensions

/**
 * Created by ahmedwahdan on 3/17/18.
 */
import android.graphics.drawable.Drawable
import android.widget.ImageView
import com.bumptech.glide.Priority
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.target.DrawableImageViewTarget
import com.wahdanz.pixabay.R

private val DEFAULT_DURATION_MS = 200

fun ImageView.load(url: String?) {
    load(this, url)
}
fun ImageView.load(url: String?, defaultImage: Int) {
    load(this, url, defaultImage = defaultImage)
}

@JvmName("privateLoad")
private fun load(
    view: ImageView,
    url: String?,
    defaultImage: Int = R.mipmap.ic_launcher
) {
    val glideRequest: GlideRequest<Drawable> = GlideApp.with(view.context)
            .load(url)
            .placeholder(defaultImage)
            .dontAnimate()
            .error(defaultImage)
            .centerCrop()
            .priority(Priority.IMMEDIATE)
            .diskCacheStrategy(DiskCacheStrategy.RESOURCE)

    glideRequest.into(DrawableImageViewTarget(view))
}
