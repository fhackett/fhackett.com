package io.github.fhackett

trait Renderable:
  def render: scalatags.Text.Modifier
