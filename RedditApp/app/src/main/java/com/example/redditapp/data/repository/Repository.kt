package com.example.redditapp.data.repository

import androidx.lifecycle.LiveData
import com.example.redditapp.domain.model.PostModel

interface Repository {

  fun getAllPosts(): LiveData<List<PostModel>>

  fun getAllOwnedPosts(): LiveData<List<PostModel>>

  fun insert(post: PostModel)

  fun deleteAll()
}