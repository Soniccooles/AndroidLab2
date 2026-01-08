package com.itandrew.androidlab2.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.itandrew.androidlab2.data.Lesson
import com.itandrew.androidlab2.databinding.ItemLessonBinding

class LessonAdapter(private val lessons: ArrayList<Lesson>) : RecyclerView.Adapter<LessonAdapter.LessonViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): LessonViewHolder {
        val binding = ItemLessonBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return LessonViewHolder(binding)
    }


    override fun onBindViewHolder(
        holder: LessonViewHolder,
        position: Int
    ) {
        val lesson = lessons[position]
        holder.bind(lesson)
    }

    override fun getItemCount(): Int {
        return lessons.size
    }

    class LessonViewHolder(private val binding: ItemLessonBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(lesson: Lesson) {
            binding.lessonTime.text = "${lesson.startTime} - ${lesson.endTime}"
            binding.lessonRoom.text = lesson.room
            binding.lessonSubject.text = lesson.subject
            binding.lessonTeacher.text = lesson.teacher
        }
    }
}