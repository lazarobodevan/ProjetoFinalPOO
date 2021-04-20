/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufv.uteis;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JDesktopPane;

/**
 *
 * @author Pedro
 */
public class Background extends JDesktopPane{
     private Image imagem;

    public Background() {
    }

    public Background(String img) {
        if (img != null) {
            imagem = new ImageIcon(getClass().getResource(img)).getImage();

        }
    }

    public Background(Image imagenInicial) {
        if (imagenInicial != null) {

            imagem = imagenInicial;
        }
    }

    public void setImagem(String img) {
        if (img != null) {
            imagem = new ImageIcon(getClass().getResource(img)).getImage();
        } else {
            imagem = null;
        }
        repaint();
    }

    public void setImagem(Image novaImagem) {
        imagem = novaImagem;
        
        repaint();
    }

    @Override
    public void paint(Graphics g) {
        if (imagem != null) {
            g.drawImage(imagem, 0, 0, getWidth(), getHeight(), this);
            setOpaque(false);            
        }else{
            setOpaque(true);
        }
        super.paint(g);
    }
}