GifDrawable
===========

[![Build Status](https://travis-ci.org/veonua/GifDrawable.png?branch=master)](https://travis-ci.org/veonua/GifDrawable)  

## Overview
`GifDrawable` is a `BitmapDrawable` class extended to provide animated gif capabilities to Android, specifically an `ImageView`. Natively the only way AFAIK to get animated gif in Android is to either user
a `WebView`, or the poorly documented `Movie` class. A `WebView` is overkill, and the `Movie` class isn't very
flexible.

This implementation of `GifDrawable` uses pure Java with minimum memory.

## Loading GIFs
Gifs can be loaded by 

Loading the gif from the input stream `GifDrawable(InputStream)`

## Animating GIFs
supports `IAnimated.start()` and `stop` methods
it starts animation from the very first frame every time

use `preloadFirstFrame()`in case you need preview of the first frame.

## Example
See the `com.veon.example.DemoActivity` for an example of using the project.

## Known issues
- transparency is not supported
- doesn't start animation until entire file is dowloaded