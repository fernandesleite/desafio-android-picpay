package com.picpay.desafio.android.view.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.picpay.desafio.android.util.ConverterUtil
import com.picpay.desafio.android.viewmodel.presentation.UserPresentation
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_item_user.view.*

class UserListItemViewHolder(
    itemView: View
) : RecyclerView.ViewHolder(itemView) {

    fun bind(userPresentation: UserPresentation) {
        itemView.apply {
            name.text = userPresentation.userName
            username.text = userPresentation.userUsername
            progressBar.visibility = ConverterUtil.setVisibility(visibility = true)
        }
        Picasso.get()
            .load(userPresentation.userImg)
            .error(userPresentation.placeholderImg)
            .into(itemView.picture, object : Callback {
                override fun onSuccess() {
                    itemView.progressBar.visibility =
                        ConverterUtil.setVisibility(visibility = false)
                }

                override fun onError(e: Exception?) {
                    itemView.progressBar.visibility =
                        ConverterUtil.setVisibility(visibility = false)
                }
            })
    }
}