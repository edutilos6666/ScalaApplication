package com.edutilos.simpleProjects

import java.awt.event.{ActionEvent, ActionListener}
import java.awt.{Font, GridLayout, Dimension}
import javax.swing._

object CalculatorGUI {
  def main(args:Array[String]): Unit = {
    CalculatorGUI.prepareGUI()
  }


  //variables
  var mainFrame:JFrame = null
  var panelRoot:JPanel = null
  var panelDisplay:JPanel = null
  var panelControllers:JPanel = null
  var fieldDisplay:JTextField = null
  var btn0:JButton = null
  var btn1:JButton= null
  var btn2:JButton = null
  var btn3:JButton = null
  var btn4:JButton = null
  var btn5:JButton = null
  var btn6:JButton = null
  var btn7:JButton = null
  var btn8:JButton = null
  var btn9:JButton = null
  var btnAdd:JButton = null
  var btnSub:JButton = null
  var btnMult:JButton = null
  var btnDiv:JButton = null
  var btnEqual:JButton = null
  var btnLeftParen:JButton = null
  var btnRightParen:JButton = null
  var btnSin:JButton = null
  var btnCos:JButton = null
  var btnAS:JButton = null

  def prepareGUI(): Unit = {
    mainFrame = new JFrame("Simple Calculator")
     mainFrame.setSize(new Dimension(500, 500))
    mainFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE)
    addComponents()
    registerListeners()
    mainFrame.setVisible(true)
  }

  def addComponents(): Unit = {
    panelRoot = new JPanel()
    panelRoot.setLayout(new BoxLayout(panelRoot, BoxLayout.Y_AXIS))
    mainFrame.getContentPane.add(panelRoot)

    //fieldDisplay
    panelDisplay = new JPanel()
    panelRoot.add(panelDisplay)
    fieldDisplay = new JTextField(30)
   // fieldDisplay.setMinimumSize(new Dimension(500, 200))
    var font = fieldDisplay.getFont()
    font = font.deriveFont(Font.PLAIN, 25f)
    fieldDisplay.setFont(font)
    fieldDisplay.setColumns(20)
    panelDisplay.add(fieldDisplay)


    //fieldControllers
    panelControllers = new JPanel(new GridLayout(4,5))
    panelRoot.add(panelControllers)

    //buttons
    btn0 = new JButton("0")
    panelControllers.add(btn0)
    btn1 = new JButton("1")
    panelControllers.add(btn1)
    btn2 = new JButton("2")
    panelControllers.add(btn2)
    btn3 = new JButton("3")
    panelControllers.add(btn3)
    btn4 = new JButton("4")
    panelControllers.add(btn4)
    btn5 = new JButton("5")
    panelControllers.add(btn5)
    btn6 = new JButton("6")
    panelControllers.add(btn6)
    btn7 = new JButton("7")
    panelControllers.add(btn7)
    btn8 = new JButton("8")
    panelControllers.add(btn8)
    btn9 = new JButton("9")
    panelControllers.add(btn9)
    btnAdd = new JButton("+")
    panelControllers.add(btnAdd)
    btnSub = new JButton("-")
    panelControllers.add(btnSub)
    btnMult = new JButton("*")
    panelControllers.add(btnMult)
    btnDiv = new JButton("/")
    panelControllers.add(btnDiv)
    btnAS = new JButton("AS")
    panelControllers.add(btnAS)
    btnLeftParen = new JButton("(")
    panelControllers.add(btnLeftParen)
    btnRightParen = new JButton(")")
    panelControllers.add(btnRightParen)
    btnSin = new JButton("sin")
    panelControllers.add(btnSin)
    btnCos = new JButton("cos")
    panelControllers.add(btnCos)
    btnEqual = new JButton("=")
    panelControllers.add(btnEqual)

  }

  def registerListeners(): Unit =  {
    btn0.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
         var text = fieldDisplay.getText
        text += "0"
        fieldDisplay.setText(text)
      }
    })

    btn1.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
    var text = fieldDisplay.getText()
        text += "1"
        fieldDisplay.setText(text)
      }
    })


    btn2.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "2"
        fieldDisplay.setText(text)
      }
    })


    btn3.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "3"
        fieldDisplay.setText(text)
      }
    })


    btn4.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "4"
        fieldDisplay.setText(text)
      }
    })

    btn5.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "5"
        fieldDisplay.setText(text)
      }
    })

    btn6.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "6"
        fieldDisplay.setText(text)
      }
    })

    btn7.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "7"
        fieldDisplay.setText(text)
      }
    })


    btn8.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "8"
        fieldDisplay.setText(text)
      }
    })

    btn9.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += "9"
        fieldDisplay.setText(text)
      }
    })

    btnAdd.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " +"
        fieldDisplay.setText(text)
      }
    })

    btnMult.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " *"
        fieldDisplay.setText(text)
      }
    })

    btnSub.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " -"
        fieldDisplay.setText(text)
      }
    })

    btnDiv.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " /"
        fieldDisplay.setText(text)
      }
    })

    btnLeftParen.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " ("
        fieldDisplay.setText(text)
      }
    })

    btnRightParen.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " )"
        fieldDisplay.setText(text)
      }
    })


    btnSin.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " sin"
        fieldDisplay.setText(text)
      }
    })

    btnCos.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
        text += " cos"
        fieldDisplay.setText(text)
      }
    })


     val engine = new CalculatorEngine

    btnEqual.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        var text = fieldDisplay.getText()
         text = text.replaceAll("sin", "Math.sin")
        text = text.replaceAll("cos", "Math.cos")
        var res:Double = engine.calculate(text)
        fieldDisplay.setText(res.toString)
      }
    })


    btnAS.addActionListener(new ActionListener {
      override def actionPerformed(e: ActionEvent): Unit = {
        fieldDisplay.setText("")
      }
    })
  }

}
