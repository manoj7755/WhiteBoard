package com.example.whiteboard

import android.annotation.SuppressLint
import android.graphics.Color
import android.os.Build
import android.os.Bundle
import android.view.View
import android.widget.FrameLayout
import android.widget.SeekBar
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomsheet.BottomSheetBehavior
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.mihir.drawingcanvas.drawingView

class MainActivity : AppCompatActivity() {
    lateinit var drawing:drawingView
    lateinit var eraserSize :TextView
    lateinit var brashAlbhaText :TextView
    @SuppressLint("MissingInflatedId")
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sheet   = findViewById<FrameLayout>(R.id.sheet)
        val seekbar = findViewById<SeekBar>(R.id.seekbar)
            drawing = findViewById(R.id.drawing_view)
            eraserSize = findViewById(R.id.eraseSize)
            brashAlbhaText = findViewById(R.id.brashAlbhaText)
            setUpDrawing()
        BottomSheetBehavior.from(sheet).apply {
            peekHeight =210
            this.state = BottomSheetBehavior.STATE_COLLAPSED
        }

    }

    private fun setUpDrawing() {
        findViewById<FloatingActionButton>(R.id.pan).setOnClickListener {
            setUpPanInitialize()
        }
        findViewById<FloatingActionButton>(R.id.eraser).setOnClickListener {
            setUpEraser()
        }
        findViewById<FloatingActionButton>(R.id.undo).setOnClickListener {
            setUpUndo()
        }
        findViewById<FloatingActionButton>(R.id.redo).setOnClickListener {
            setUpRedo()
        }
        findViewById<FloatingActionButton>(R.id.cleanBoard).setOnClickListener {
            setUpCleanBoard()
        }
        findViewById<FloatingActionButton>(R.id.saveDrawing).setOnClickListener {
            setUpsaveDrawing()
        }
        findViewById<FloatingActionButton>(R.id.blueColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.BLUE)
        }
        findViewById<FloatingActionButton>(R.id.redColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.RED)
        }
        findViewById<FloatingActionButton>(R.id.greenColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.GREEN)
        }
        findViewById<FloatingActionButton>(R.id.yellowColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.YELLOW)
        }
        findViewById<FloatingActionButton>(R.id.blackColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.BLACK)
        }
        findViewById<FloatingActionButton>(R.id.whiteColor_btn).setOnClickListener {
            drawing.setBrushColor(Color.WHITE)
        }
        findViewById<SeekBar>(R.id.seekbar).setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
             eraserSize.text = p1.toString()
                drawing.setSizeForBrush(p1)
            }


            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })

        findViewById<SeekBar>(R.id.brashAlbhaSize).setOnSeekBarChangeListener(object :SeekBar.OnSeekBarChangeListener{
            override fun onProgressChanged(p0: SeekBar?, p1: Int, p2: Boolean) {
                brashAlbhaText.text = p1.toString()
                drawing.setBrushAlpha(p1)
            }

            override fun onStartTrackingTouch(p0: SeekBar?) {

            }

            override fun onStopTrackingTouch(p0: SeekBar?) {

            }

        })
    }

    private fun setUpPanInitialize() {
        drawing.setBrushColor(Color.BLACK)
    }

    private fun setUpsaveDrawing() {
            drawing.getDrawing()

    }

    private fun setUpCleanBoard() {
        drawing.clearDrawingBoard()
    }

    private fun setUpRedo() {
        drawing.redo()
    }

    private fun setUpUndo() {
        drawing.undo()
    }

    private fun setUpEraser() {
        drawing.erase(Color.WHITE)
    }
}