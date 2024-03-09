package com.musicHub.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.musicHub.entities.Playlist;

public interface PlaylistRepo extends JpaRepository<Playlist, Integer>
{

}
