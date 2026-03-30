import { useState } from "react";

function App() {
  const [project, setProject] = useState("");
  const [job, setJob] = useState("");
  const [result, setResult] = useState(null);
  const [loading, setLoading] = useState(false);

  const handleAnalyze = () => {
     setLoading(true);

     setTimeout(() => {
    let match = Math.floor(Math.random() * 100);

    let confidence =
      match >= 75 ? "High 🚀" :
      match >= 50 ? "Medium 👍" :
      "Low 📚";

      let suggestion =
      match >= 75 ? "Apply Now 🚀" :
      match >= 50 ? "Almost Ready 👍" :
      "Learn more skills 📚";

    setResult({
      skills: ["Java", "SQL"],
      match,
      confidence,
      suggestion
    });

    setLoading(false);
  }, 1500);
};

  return (
    <div style={{
  minHeight: "100vh",
  display: "flex",
  justifyContent: "center",
  alignItems: "center",
  background: "#f4f6f8"
}}>
  <div style={{
    background: "white",
    padding: "30px",
    borderRadius: "10px",
    width: "400px",
    boxShadow: "0 0 10px rgba(0,0,0,0.1)"
  }}>

  </div>
      <h1>🚀 CareerGap AI</h1>

      <h3>Enter Your Project</h3>
      <textarea
        style={{
    width: "100%",
    height: "80px",
    marginBottom: "10px",
    padding: "10px",
    borderRadius: "5px",
    border: "1px solid #ccc"
  }}
/>

      <h3>Enter Job Description</h3>
      <textarea
         style={{
    width: "100%",
    height: "80px",
    marginBottom: "10px",
    padding: "10px",
    borderRadius: "5px",
    border: "1px solid #ccc"
  }}
/>

      <br /><br />

      <button
  style={{
    width: "100%",
    padding: "10px",
    background: "#007bff",
    color: "white",
    border: "none",
    borderRadius: "5px",
    cursor: "pointer"
  }}
  onClick={handleAnalyze}
>
  Analyze
</button>

      {/* RESULT SECTION */}
      {result && (
        <div style={{ marginTop: "20px" }}>
          <h2>Result</h2>
          <p><b>Skills:</b> {result.skills.join(", ")}</p>
          <p><b>Match:</b> {result.match}%</p>
          <p><b>Confidence:</b> {result.confidence}</p>
          <p><b>Suggestion:</b> {result.suggestion}</p>

          {/* Progress Bar */}
          <div style={{ width: "300px", background: "#ddd" }}>
            <div
              style={{
                width: `${result.match}%`,
                background: "green",
                color: "white"
              }}
            >
              {result.match}%
            </div>
          </div>
        </div>
      )}
    </div>
  );
}

export default App;