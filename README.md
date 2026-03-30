# 🍅 TomatoScan  
### Mobile Tomato Disease Detection using Deep Learning & Machine Learning

<img width="1380" height="752" alt="Gemini_Generated_Image_h4dg4ah4dg4ah4dg" src="https://github.com/user-attachments/assets/0796abda-b2f5-4dfe-9587-dc801471efcc" />

---

## 📌 Overview
TomatoScan is an end-to-end computer vision system that classifies **10 tomato leaf conditions (9 diseases + 1 healthy class)** using deep learning models and deploys the best-performing model to **Android via TensorFlow Lite (TFLite)** for fully offline inference.

The system benchmarks multiple architectures including **VGG16, InceptionV3, ResNet50, and a custom CNN**, and compares them against classical machine learning models using ensemble stacking.

---

## 🚨 Problem Statement
Tomato crop diseases cause major yield losses for farmers, especially in remote areas without access to agricultural experts or stable internet connectivity.

**Goal:** Build an accurate, fast, and offline disease detection system that works directly from a smartphone camera.

---

## 🎯 Objectives
- Train deep learning models for 10-class tomato disease classification
- Benchmark multiple CNN architectures (VGG16, InceptionV3, ResNet50, Custom CNN)
- Evaluate classical ML models using CNN feature extraction (stacking approach)
- Deploy best model to Android using TensorFlow Lite
- Achieve ≥90% accuracy on test dataset

---

## 📊 Dataset
- **Name:** PlantVillage Tomato Leaf Dataset (Kaggle)
- **Size:** ~11,000 images
- **Classes:** 10 (9 diseases + 1 healthy)
- **Format:** RGB images resized to 128×128
- **Source:** https://www.kaggle.com/datasets/ashishmotwani/tomato

---

## 🧠 Methodology

### 🔹 Deep Learning Models
- VGG16 (Best performing)
- InceptionV3
- ResNet50
- Custom CNN

All models use:
- Transfer learning (ImageNet weights)
- GlobalAveragePooling2D
- Dense(120, ReLU)
- Dense(10, Softmax)

---

### 🔹 Ensemble Machine Learning
CNN feature extraction + classical ML classifiers:
- Random Forest
- SVM
- KNN
- Logistic Regression
- Naive Bayes
- Decision Tree

---

### 🔹 Training Configuration
- Optimizer: Adam (lr = 0.0001)
- Loss: Categorical Crossentropy
- Batch size: 32
- Epochs: 20
- Early stopping on validation loss

---

## 🏆 Results

| Model         | Accuracy | F1 Score |
|--------------|----------|----------|
| VGG16        | **94.0%** | **0.94** |
| InceptionV3  | 93.7%    | 0.929    |
| ResNet50     | 93.1%    | 0.921    |
| Custom CNN   | 84.9%    | 0.843    |

### 🔍 Key Insights
- VGG16 provides best trade-off between accuracy and model size
- Transfer learning significantly outperforms ensemble stacking (~94% vs ~76%)
- Leaf diseases with similar visual patterns (e.g., Early Blight vs Septoria) are most difficult to classify
- TFLite quantization reduces model size significantly with minimal accuracy loss

---

## 📱 Android Deployment
- Framework: Jetpack Compose
- Camera: CameraX
- Inference: TensorFlow Lite (offline)
- Features:
  - Real-time camera classification
  - Gallery image classification
  - Top-3 predictions
  - Confidence score visualization
  - Disease information cards

---

## ⚙️ Tech Stack
- Python 3.10
- TensorFlow / Keras
- Scikit-learn
- OpenCV
- NumPy
- Pandas
- TensorFlow Lite
- Kotlin
- Jetpack Compose
- CameraX

---

## 📁 Project Structure
  app/ → Android application (MainActivity, UI, CameraX)
  models/ → Trained .tflite models (VGG16, InceptionV3, ResNet50)
  notebook/ → Training & evaluation pipeline (Jupyter Notebook)
  utils/ → TFLite inference wrapper (ClassifierEngine.kt)
  assets/ → Active model + labels file

## 🚀 Installation & Usage

### 1. Clone Repository

bash
git clone https://github.com/RaphaelNazareth/tomatoscan
cd tomatoscan

### 2. Install Python Dependencies
pip install tensorflow scikit-learn opencv-python matplotlib pandas
### 3. Run Training Notebook

Open:

Mobile_Tomato_Disease_Detection_using_CNN___ML.ipynb

Run all cells sequentially.

### 4. Android Setup
./gradlew installDebug

Steps:

Open project in Android Studio
Place .tflite model into:
android/app/src/main/assets/
Run on device or emulator

## 📈 Key Findings & 🔮 Future Improvements

### 📈 Key Findings
- Transfer learning converges very quickly (3–5 epochs), making training efficient even on limited compute resources  
- VGG16 performs best at 128×128 resolution, offering the best balance between accuracy and model size  
- Classical ensemble ML methods underperform due to limited feature expressiveness compared to end-to-end CNN learning  
- Early Blight vs Septoria Leaf Spot remains the most challenging classification pair due to high visual similarity  
- Model quantization significantly reduces model size, enabling deployment on low-end mobile devices with minimal accuracy loss  

---

### 🔮 Future Improvements
- Replace backbone models with **MobileNetV3 / EfficientNet-Lite** for smaller and more efficient deployment  
- Add **Grad-CAM visualization** to improve model interpretability and highlight affected leaf regions  
- Implement **disease severity estimation** (mild / moderate / severe) based on lesion coverage  
- Add **multi-language support** (Bahasa Indonesia, English, Spanish) for broader accessibility  
- Enable **crowdsourced dataset collection** directly from the mobile app to continuously improve the model  
- Provide optional **cloud inference fallback API** using FastAPI / Flask for low-end or unsupported devices  

---

## 👨‍💻 Author

**Raphael Nazareth**  
Computer Engineering | IoT & Machine Learning Enthusiast
