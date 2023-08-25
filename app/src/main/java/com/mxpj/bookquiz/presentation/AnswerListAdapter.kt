package com.mxpj.bookquiz.presentation

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.content.res.AppCompatResources
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.mxpj.bookquiz.R
import com.mxpj.bookquiz.databinding.ItemAnswerBinding
import com.mxpj.bookquiz.domain.Answer

class AnswerListAdapter(context: Context): RecyclerView.Adapter<AnswerListAdapter.AnswerViewHolder>() {

    private var resourceContext: Context? = context

    var answerList = listOf<Answer>()
        @SuppressLint("NotifyDataSetChanged")
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerViewHolder {
        val itemAnswerBinding = ItemAnswerBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return AnswerViewHolder(itemAnswerBinding)
    }

    override fun onBindViewHolder(holder: AnswerViewHolder, position: Int) {
        val item = answerList[position]
        with(holder.binding){
            val bookImages = listOf(ivBook1,ivBook2,ivBook3)
            for((index, book) in item.question.books.withIndex()){
                bookImages[index].setImageResource(book.imageResource)
                if(item.selectedBook == book){
                    when(item.question.rightBook == item.selectedBook){
                        true -> {
                            bookImages[index].foreground =
                                AppCompatResources.getDrawable(resourceContext!!, R.drawable.fg_right_book)
                        }
                        false -> {
                            bookImages[index].foreground =
                                AppCompatResources.getDrawable(resourceContext!!, R.drawable.fg_wrong_book)
                        }
                    }
                }
            }
            tvText.text = item.question.rightBook.text
        }
    }

    override fun getItemCount(): Int {
        return answerList.size
    }

    override fun onDetachedFromRecyclerView(recyclerView: RecyclerView) {
        super.onDetachedFromRecyclerView(recyclerView)
        resourceContext = null
    }

    class AnswerViewHolder(val binding: ItemAnswerBinding): ViewHolder(binding.root)
}